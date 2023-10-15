import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class Debilitar implements Habilidad {

	@Override
	public void realizar(Batalla batalla) {
		realizarDebilitamiento(batalla);
	}

	private void realizarDebilitamiento(Batalla batalla) {
		String personajeActual = batalla.getPersonajeActual();
		Map<String, Properties> personajes=batalla.getPersonajes();
		Integer danio = Integer.valueOf(personajes.get(personajeActual).getProperty("ataque"));
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
