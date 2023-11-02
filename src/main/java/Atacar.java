import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class Atacar implements Habilidad {

	@Override
	public void realizar(Batalla batalla) {
		int personajeActual = batalla.getPersonajeActual();
		int danio = Integer.valueOf(batalla.getPersonajes().get(personajeActual).getProperty("ataque"));
		ArrayList<Properties> personajesAux = batalla.getPersonajes();
		int id=0;
		for (Properties property : personajesAux) {
			if (id==personajeActual) {
				String vidaStr = property.getProperty("vida");
				int vida = Integer.parseInt(vidaStr);
				int nuevaVida = vida - danio;
				property.setProperty("vida", String.valueOf(nuevaVida));
			}
			id++;
		}
		batalla.setPersonajes(personajesAux);
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
