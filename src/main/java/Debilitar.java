import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class Debilitar implements Habilidad {

	@Override
	public void realizar(Batalla batalla) {
		String personajeActual = batalla.getPersonajeActual();
		Map<String, Properties> caracteristicas = batalla.getCaracteristicas();
		
		for (Map.Entry<String, Properties> entry : caracteristicas.entrySet()) {
            String nombrePersonaje = entry.getKey();
            if (!nombrePersonaje.equals(personajeActual)) {
                Properties caracteristicasPersonaje = entry.getValue();
            	String ataquePersonajeEnemigo = caracteristicasPersonaje.getProperty("ataque");
            	int ataque = Integer.parseInt(ataquePersonajeEnemigo);
				int nuevoAtaque = (int) Math.ceil(ataque/2.0);
				caracteristicasPersonaje.setProperty("ataque", String.valueOf(nuevoAtaque));
				caracteristicas.put(nombrePersonaje, caracteristicasPersonaje);
            }
        }
		
		batalla.setCaracteristicas(caracteristicas);
	}
	

	@Override
	public String getNombre() {
		return "Debilitar";
	}

	@Override
	public String getDescripcion() {
		return "Reduce el ataque del rival a la mitad";
	}

}
