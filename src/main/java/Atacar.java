import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class Atacar implements Habilidad {

	@Override
	public void realizar(Batalla batalla) {
		String personajeActual = batalla.getPersonajeActual();
		int danio = Integer.valueOf(batalla.getCaracteristicasPersonaje(personajeActual).getProperty("ataque"));
		Map<String, Properties> caracteristicas = batalla.getCaracteristicas();
		for (Map.Entry<String, Properties> entry : caracteristicas.entrySet()) {
            String nombrePersonaje = entry.getKey();
            Properties caracteristicasPersonaje = entry.getValue();
            // Verificar si la clave es "fabi"
            if (!nombrePersonaje.equals(personajeActual)) {
            	String vidaStr = caracteristicasPersonaje.getProperty("vida");
				int vida = Integer.parseInt(vidaStr);
				int nuevaVida = vida - danio;
				caracteristicasPersonaje.setProperty("vida", String.valueOf(nuevaVida));
            }
        }
		batalla.setCaracteristicas(caracteristicas);
	}

	@Override
	public String getNombre() {
		return "Atacar";
	}

	@Override
	public String getDescripcion() {
		return "Infringe puntos de daño segun la caracteristica de ataque del personaje";
	}

}
