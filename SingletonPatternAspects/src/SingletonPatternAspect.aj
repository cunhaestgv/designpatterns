import com.es2.singleton.*;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public aspect SingletonPatternAspect {

	String[] methodsAndParameters = {
			"Missing test that validates getInstance()",
			"Missing test that validates setPath()",
			"Missing test that validates getPath()",
			"Missing test that validates getConnectionString()",
			"Missing test that validates setConnectionString()",
			"Missing test that validates setConnectionString() for null values",
			"Missing test that validates setPath() for null values",
			"Missing test that validates the visibility level of constructor"
	};

	@Before("execution(* Registry.getInstance(..))")
	public void call1(){
		methodsAndParameters[0] = null;
	}
	
	@Before("execution(* Registry.setPath(..))")
	public void call2(){
		methodsAndParameters[1] = null;
	}
	@Before("execution(* Registry.getPath(..))")
	public void call3(){
		methodsAndParameters[2] = null;
	}
	@Before("execution(* Registry.getConnectionString(..))")
	public void call4(){
		methodsAndParameters[3] = null;
	}
	@Before("execution(* Registry.setConnectionString(..))")
	public void call5(){
		methodsAndParameters[4] = null;
	}
	@Before("execution(* Registry.setConnectionString(..))")
	public void call6(JoinPoint jp){
		Object[] args = jp.getArgs();
		if(args[0] == null) methodsAndParameters[5] = null;
		
	}
	@Before("execution(* Registry.setPath(..))")
	public void call7(JoinPoint jp){
		Object[] args = jp.getArgs();
		if(args[0] == null) methodsAndParameters[6] = null;
		
	}
	/*@Before("call(* java.lang.reflect.Modifier.isPrivate(..)) || call(* java.lang.reflect.Modifier.isPublic(..))")
	public void call8(){
		methodsAndParameters[7] = null;
	}*/

	@Before("execution(End.new(..))")
	public  void calln() {
		String errors = "";

		for(String s:methodsAndParameters)
			if(s!=null) errors+= s + "\n";

		if(errors != "") 
			throw new RuntimeException(errors);
		
	}


}
