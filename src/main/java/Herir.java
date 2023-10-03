import java.util.Map;

import tp.pp2.rpg.experience.core.entidades.BatallaContexto;
import tp.pp2.rpg.experience.core.entidades.Personaje;
import tp.pp2.rpg.experience.core.entidades.interfaces.Habilidad;

public class Herir implements Habilidad {

	@Override
	public void realizar(BatallaContexto contexto) {
		Map<Personaje, Integer> vidas = contexto.getVidas();
		for (Map.Entry<Personaje, Integer> entry : vidas.entrySet()) {
		    Personaje personaje = entry.getKey();
		    Integer vida = entry.getValue();
		    if (personaje != contexto.getTurno()) {
		        vidas.put(personaje, vida - 10);
		    }
		}
	}

	@Override
	public String getDescripcion() {
		return "Realiza danio de 10";
	}

	@Override
	public String getNombre() {
		return "Herir";
	}

}
