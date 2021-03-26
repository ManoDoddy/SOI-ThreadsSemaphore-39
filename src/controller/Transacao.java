package controller;

import java.util.concurrent.Semaphore;

public class Transacao extends Thread{

	Semaphore saque;
	Semaphore deposito;
	
	public Transacao(Semaphore saque, Semaphore deposito) {
		this.saque = saque;
		this.deposito = deposito;
	}
	
	@Override
	public void run() {
		transacionar();
	}

	private void transacionar() {
		int type = (int) (Math.random() * 101);
		if(type%2==0) {
			try {
				saque.acquire();
				sacar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				saque.release();
			}
		}else {
			try {
				deposito.acquire();
				depositar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				deposito.release();
			}
		}
	}

	private void depositar() {
		System.out.println("Pessoa #"+getId()+" está depositando.");
	}

	private void sacar() {
		System.out.println("Pessoa #"+getId()+" está sacando.");
	}
}
