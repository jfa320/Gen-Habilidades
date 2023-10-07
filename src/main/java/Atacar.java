import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class Atacar implements Habilidad {

	@Override
	public void realizar(Batalla batalla) {
		String personajeActual = batalla.getPersonajeActual();
		Integer danio = Integer.valueOf(batalla.getPersonajes().get(personajeActual).getProperty("ataque"));
		Map<String, Properties> personajesAux = batalla.getPersonajes();
		for (Map.Entry<String, Properties> entry : personajesAux.entrySet()) {
			String key = entry.getKey();
			Properties properties = entry.getValue();
			if (!key.equals(personajeActual)) {
				String vidaStr = properties.getProperty("vida");
				int vida = Integer.parseInt(vidaStr);
				int nuevaVida = vida - danio;
				properties.setProperty("vida", String.valueOf(nuevaVida));
			}
		}
		batalla.setPersonajes(personajesAux);

	}

	@Override
	public String getNombre() {
		return "Atacar";
	}

	@Override
	public String getDescripcion() {
		return "Infringe 800 puntos de daño según la caracteristica de ataque del personaje";
	}

}
