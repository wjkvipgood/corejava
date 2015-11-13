package corejava.compare;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		SortedSet<Person> persons = new TreeSet<Person>();
		persons.add(new Person(19, "Tom"));
		persons.add(new Person(21, "Harry"));
		persons.add(new Person(23, "Jimmy"));
		System.out.println(persons);
		
		SortedSet<Person> sortByName = new TreeSet<Person>(new 
				Comparator<Person>(){

					@Override
					public int compare(Person o1, Person o2) {
						String name1 = o1.getName();
						String name2 = o2.getName();
						return name1.compareTo(name2);
					}
					
				});
		sortByName.add(new Person(19, "Tom"));
		sortByName.add(new Person(21, "Harry"));
		sortByName.add(new Person(23, "Jimmy"));
		System.out.println(sortByName);
	}
}
