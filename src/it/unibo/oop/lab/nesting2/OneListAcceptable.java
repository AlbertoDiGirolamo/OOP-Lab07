package it.unibo.oop.lab.nesting2;
import java.util.ArrayList;

import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list;
	public OneListAcceptable(List<T> list) {
		this.list = list;
	}
	private List<T> listTmp = new ArrayList<>();

	public Acceptor<T> acceptor() {

		return new Acceptor<T>() {

		
			public void accept(T newElement) throws ElementNotAcceptedException {
				if(!list.contains(newElement)) {
					throw new ElementNotAcceptedException(newElement);
				}
				listTmp.add(newElement);
				
			}

		
			public void end() throws EndNotAcceptedException {
				if (listTmp.size() != list.size()) {
					throw new EndNotAcceptedException();
				}
			
			}
		
		};

	}

}
