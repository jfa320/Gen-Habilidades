import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class Herir implements Habilidad{
	Batalla batalla;
	
	@Override
	public void realizar() {
		String personajeActual = batalla.getPersonajeActual();
		int danio = 10;
		Map<String, Properties> caracteristicas = batalla.getCaracteristicas();
		for (Map.Entry<String, Properties> entry : caracteristicas.entrySet()) {
            String nombrePersonaje = entry.getKey();
            if (!nombrePersonaje.equals(personajeActual)) {
                Properties caracteristicasPersonaje = entry.getValue();
            	String vidaStr = caracteristicasPersonaje.getProperty("vida");
				int vida = Integer.parseInt(vidaStr);
				int nuevaVida = vida - danio;
				caracteristicasPersonaje.setProperty("vida", String.valueOf(nuevaVida));
				caracteristicas.put(nombrePersonaje, caracteristicasPersonaje);
            }
        }
		batalla.setCaracteristicas(caracteristicas);
	}

	@Override
	public String getNombre() {
		return "Herir";
	}

	@Override
	public String getDescripcion() {
		return "Infringe 10 puntos de daño al personaje rival";
	}

	@Override
	public void setBatallaInicial(Batalla batalla) {
		this.batalla=batalla;
	}
}
