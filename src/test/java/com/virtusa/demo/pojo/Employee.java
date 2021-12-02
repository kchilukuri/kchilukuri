package com.virtusa.demo.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee>{

	private int id;
	private String name;
	private String dept;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}
	public Employee(int id, String name, String dept) {
		this.id=id;
		this.name=name;
		this.dept=dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public int compareTo(Employee o) {
		if(this.getId() > o.getId())
			return 1;
		else return -1;
		
	}
	
	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(23,"emp2","CCB"));
		emp.add(new Employee(3,"emp2","CAB"));
		emp.add(new Employee(14,"emp1","CIB"));
		emp.add(new Employee(123,"emp4","CMB"));
		Collections.sort(emp);
		for(Employee e: emp) {
			System.out.println("Employee list: "+e);
		}
		
		Comparator<Employee> comparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getId() < o2.getId())
					return 1;
				else return -1;
			}
		};
			
		Collections.sort(emp, comparator);
		
		for(Employee e: emp) {
			System.out.println("Employee list: "+e);
		}
					
		Comparator<Employee> comp1 = Comparator.comparing(Employee::getName).thenComparing(Employee::getDept);
		Collections.sort(emp, comp1);
		for(Employee e: emp) {
			System.out.println("Employee list: "+e);
		}
	}
}
