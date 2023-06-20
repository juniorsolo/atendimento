package com.junior.atendimento;

public class LocalVarType {

	public static void main(String[] args) {
		var x = 12;
		FuncSum fun = (var a, var b) -> a - b;
		
		System.out.println(fun.operation( 4,x));
		
		String a = " a ";
		
		System.out.println(a);
		System.out.println(a.strip());
		System.out.println(a.stripIndent());
		System.out.println(a.stripTrailing());
		System.out.println(a.repeat(5));
		
	}
	
}

interface FuncSum{
	int operation(int a, int b);
}
