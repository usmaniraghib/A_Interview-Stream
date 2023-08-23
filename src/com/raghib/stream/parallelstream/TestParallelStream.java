package com.raghib.stream.parallelstream;

import java.util.Arrays;
import java.util.List;

class Student {
	private String name;
	private int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

public class TestParallelStream {

	public static void main(String[] args) {
		List<Student> studentObject = Arrays.asList(new Student("A", 100), new Student("B", 80), new Student("Z", 70),
				new Student("P", 50), new Student("Y", 100), new Student("U", 30));

		// Using Stream - Sequential
		System.out.println("Sequential Stream");
		studentObject.stream().filter(a -> a.getScore() >= 70)
				.forEach(b -> System.out.println("Name : " + b.getName() + " , " + "Score : " + b.getScore()));

		// Using Stream - Parallel
		System.out.println("Parallel Stream - Improve Performance");
		studentObject.parallelStream().filter(a -> a.getScore() >= 70)
				.forEach(b -> System.out.println("Name : " + b.getName() + " , " + "Score : " + b.getScore()));

		// Convert Normal Stream into Parallel Stream.
		System.out.println("Convert Normal Stream into Parallel Stream");
		studentObject.stream().parallel().filter(a -> a.getScore() >= 70)
				.forEach(b -> System.out.println("Name : " + b.getName() + " , " + "Score : " + b.getScore()));

	}

}
