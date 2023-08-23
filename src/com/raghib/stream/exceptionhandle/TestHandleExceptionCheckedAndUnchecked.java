package com.raghib.stream.exceptionhandle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestHandleExceptionCheckedAndUnchecked {
	
	static <Target> Consumer<Target> handleCheckedExceptionConsumer(CheckedExceptionHandlerConsumer<Target,Exception> handlerConsumer) {
		return obj -> {
			try {
				handlerConsumer.accept(obj);
			} catch(Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}	
	
	public static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer, Class<ExObj> exObjClass) {
		
		return obj -> {
			try {
				targetConsumer.accept(obj);
			} catch(Exception ex) {
				try {
					ExObj exObj = exObjClass.cast(ex);
					System.out.println("Exception Details : "+exObj.getMessage());
				} catch(ClassCastException cce) {
					throw cce;
				}
			}
		};
	}
	
	public static void unCheckedException() {
		System.out.println("Handle Un-Checked Exception");
		List<String> list = Arrays.asList("44", "373", "xyz"); //NumberFormatException
		List<Integer> list1 = Arrays.asList(1, 0); //ArithmeticException

		list.forEach(handleGenericException(a -> System.out.println(Integer.parseInt(a)), NumberFormatException.class));

		list1.forEach(handleGenericException(b -> System.out.println(10 / b), ArithmeticException.class));
	}
	
	public static void checkedException() {
		System.out.println("Handle Checked Exception");
		List<Integer> list2 = Arrays.asList(10,20);
		list2.forEach(
				handleCheckedExceptionConsumer(
						i -> {
							Thread.sleep(i); //InterruptedException
							System.out.println(i);
						}
				));
	}
	
	public static void main(String[] args) {
		unCheckedException();
		checkedException();
	}
}
