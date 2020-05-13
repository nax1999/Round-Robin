import java.util.ArrayList;
import java.util.Scanner;
public class RoundRobin {
	private int quantum;
	private Proceso[] proceso;
	private int numProceso;
	
		
	public int getQuantum() {
		return quantum;
	}
	
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	public Proceso[] getProceso() {
		return proceso;
	}

	public void setProceso(Proceso[] proceso) {
		this.proceso = proceso;
	}

	public int getNumProceso() {
		return numProceso;
	}

	public void setNumProceso(int numProceso) {
		this.numProceso = numProceso;
	}

	public void InicializarRoundRobin() {
		System.out.println("Introduce el quantum (Solo numeros mayores que 0):");
		Scanner teclado = new Scanner(System.in);
		this.setQuantum(teclado.nextInt());
		System.out.println("Introduce el numero de procesos (Solo numeros mayores que 0):");
		this.setNumProceso(teclado.nextInt());
		proceso=new Proceso[this.getNumProceso()];
		for(int i=0;i<this.getNumProceso();i++) {
			proceso[i]=new Proceso();
		}
		for(int i=0;i<this.getNumProceso();i++) {
			proceso[i].setId(i+1);
			System.out.println("Introduzca instante de llegada de proceso "+(i+1));
			proceso[i].setInstanteLlegada(teclado.nextInt());
			proceso[i].setInstanteLlegadaAux(proceso[i].getInstanteLlegada());
			System.out.println("Introduzca duracion de proceso "+(i+1));
			proceso[i].setTicksProceso(teclado.nextInt());
			proceso[i].setTicksProcesoAux(proceso[i].getTicksProceso());
		}
		teclado.close();
	}
	
	public void Algoritmo() {
		boolean terminado=false;
		int tick=0;
		int quantumAux=0;
		Proceso cpu = new Proceso();
		ArrayList<Proceso> cola = new ArrayList<Proceso>();
		do {
			//System.out.println("Tick "+tick);
			int procesoNum=0;
			for(int i=0;i<this.getNumProceso();i++) {//Buscamos el proceso que antes empieza
				if(i==0) {
					procesoNum=proceso[i].getId()-1;
				}
				else {
					if(proceso[procesoNum].getInstanteLlegada()>proceso[i].getInstanteLlegada() || proceso[procesoNum].getInstanteLlegada()==-1) {
						procesoNum=proceso[i].getId()-1;
					}
				}
			}
			//System.out.println("Proceso que va a empezar: "+proceso[procesoNum].getId());
			if(proceso[procesoNum].getInstanteLlegada()==tick) {//Comprobamos si el proceso tiene que empezar
				//System.out.println("Empieza proceso "+proceso[procesoNum].getId());
				if(cpu.getId()==0) {
					cpu=proceso[procesoNum];
					cpu.setInicio(tick);
					cpu.setInstanteLlegada(-1);
				}
				else {
					proceso[procesoNum].setInstanteLlegada(-1);
					cola.add(proceso[procesoNum]);
				}
			}
			
			if(cpu.getId()!=0) {
				if(tick!=0) {
					cpu.setTicksProceso(cpu.getTicksProceso()-1);					
				}
				if(cpu.getTicksProceso()<=0) {
					cpu.setFin(tick);
					//System.out.println("El proceso "+cpu.getId()+" ha terminado.");
					System.out.println("Proceso "+cpu.getId()+". Inicio: "+cpu.getInicio()+". Fin: "+cpu.getFin()+". T Resp: "+(cpu.getFin()-cpu.getInstanteLlegadaAux())+". T Espera: "+((cpu.getFin()-cpu.getInstanteLlegadaAux())-cpu.getTicksProcesoAux())+". P: "+((float)(cpu.getFin()-cpu.getInstanteLlegadaAux())/cpu.getTicksProcesoAux()));     
					if(!cola.isEmpty()) {
						cpu = cola.get(0);
						if(cpu.getInicio()==-1) {
							cpu.setInicio(tick);
						}
						cola.remove(0);
						quantumAux=0;						
					}
					else {
						terminado=true;
					}
				}
				else {
					if(tick!=0) {
						quantumAux++;						
					}
					if(quantumAux>=quantum) {
						//System.out.println("Quantum activado");
						quantumAux=0;
						cola.add(cpu);
						cpu = cola.get(0);
						if(cpu.getInicio()==-1) {
							cpu.setInicio(tick);
						}
						cola.remove(0);
					}
				}
			}
			tick++;
		}while(!terminado);
		System.out.println("Terminado");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoundRobin roundRobin = new RoundRobin();
		roundRobin.InicializarRoundRobin();
		roundRobin.Algoritmo();
	}

}
