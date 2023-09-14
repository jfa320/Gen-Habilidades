package gen.habilidades;

import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;

public class DañoDirecto implements Habilidad {
	String nombre;
	Integer danio;
	
	public DañoDirecto(String nombre,Integer danio) {
		this.nombre=nombre;
		this.danio=danio;
	}
	
	@Override
	public Integer daniar(Personaje personajeAtacado) {
		return -this.danio;
	}

}
