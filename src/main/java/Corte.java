

import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;

public class Corte implements Habilidad{

	@Override
	public Integer daniar(Personaje personajeAtacado) {
		return -10;
	}

	@Override
	public String getDescripcion() {
		return "Corte | Ataque sencillo que quita -10 de vida";
	}

}
