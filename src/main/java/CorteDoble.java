import tp.pp2.rpg.generator.core.entidades.Personaje;
import tp.pp2.rpg.generator.core.entidades.interfaces.Habilidad;

public class CorteDoble implements Habilidad {
	int turnoNro=0;
	@Override
	public Integer daniar(Personaje personajeAtacado) {
		turnoNro++;
		return (turnoNro%2==0)?-20:-10;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "Corte Doble | Ataque -10 con doble ataque en turnos pares";
	}

}
