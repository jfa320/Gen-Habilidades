

import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;

public class Herir implements Habilidad{
	@Override
	public Integer daniar(Personaje personajeAtacado) {
		return -5;
	}

	@Override
	public String getDescripcion() {
		return "Herir | Ataque simple que quita -5 de vida";
	}
}
