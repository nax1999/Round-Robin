
public class Proceso {
	private int id;
	private int ticksProceso;
	private int instanteLlegada;
	private int inicio;
	private int fin;
	private int ticksProcesoAux;
	private int instanteLlegadaAux;
	
	public int getInstanteLlegadaAux() {
		return instanteLlegadaAux;
	}
	public void setInstanteLlegadaAux(int instanteLlegadaAux) {
		this.instanteLlegadaAux = instanteLlegadaAux;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}
	public int getInstanteLlegada() {
		return instanteLlegada;
	}
	public void setInstanteLlegada(int instanteLlegada) {
		this.instanteLlegada = instanteLlegada;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTicksProceso() {
		return ticksProceso;
	}
	public void setTicksProceso(int ticksProceso) {
		this.ticksProceso = ticksProceso;
	}
	public Proceso(int id, int ticksProceso, int instanteLlegada,int inicio,int fin) {
		super();
		this.id = id;
		this.ticksProceso = ticksProceso;
		this.ticksProcesoAux =ticksProceso;
		this.instanteLlegada = instanteLlegada;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public Proceso() {
		super();
		this.id = 0;
		this.ticksProceso = 0;
		this.ticksProcesoAux = 0;
		this.instanteLlegada = -1;
		this.inicio = -1;
		this.fin = 0;
	}
	public int getTicksProcesoAux() {
		return ticksProcesoAux;
	}
	public void setTicksProcesoAux(int ticksProcesoAux) {
		this.ticksProcesoAux = ticksProcesoAux;
	}
	
	
}
