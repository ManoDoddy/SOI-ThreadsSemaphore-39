package view;

import java.util.concurrent.Semaphore;

import controller.Transacao;

public class Main {

	public static void main(String[] args) {
		
		Semaphore saque = new Semaphore(1);
		Semaphore deposito = new Semaphore(1);
		
		for (int i = 0; i < 20; i++) {
			new Transacao(saque, deposito).start();
		}
	}

}
