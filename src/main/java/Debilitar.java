import java.util.Map;
import java.util.Properties;

import tp.pp2.rpg.experience.core.entidades.Batalla;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class Debilitar implements Habilidad {
	private Batalla batalla;
	
	@Override
	public void realizar() {
		realizarDebilitamiento();
	}

	private void realizarDebilitamiento() {
		String personajeActual = batalla.getPersonajeActual();
		Map<String, Properties> personajesAux = batalla.getCaracteristicas();
		for (Map.Entry<String, Properties> entry : personajesAux.entrySet()) {
			String key = entry.getKey();
			Properties properties = entry.getValue();
			if (!key.equals(personajeActual)) {
				String ataqueStr = properties.getProperty("ataque");
				int ataque = Integer.parseInt(ataqueStr);
				int nuevoAtaque = (int) Math.ceil(ataque/2.0);
				properties.setProperty("ataque", String.valueOf(nuevoAtaque));
			}
		}
		batalla.setCaracteristicas(personajesAux);
	}


	@Override
	public String getNombre() {
		return "Debilitar";
	}

	@Override
	public String getDescripcion() {
		return "Reduce el ataque del rival a la mitad";
	}

	@Override
	public void setBatallaInicial(Batalla batalla) {
		this.batalla=batalla;
		
	}

}
