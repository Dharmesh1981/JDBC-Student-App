import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class start {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcom to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to Display student");
			System.out.println("PRESS 4 to Exit app");
			int c = Integer.parseInt(br.readLine());
			
			if (c==1)
			{
				//add student..
				System.out.println("Enter user name :");
				String name = br.readLine();
				
				System.out.println("Enter user phone :");
				String phone = br.readLine();
				
				System.out.println("Enter user city :");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				boolean answar = StudentDao.insertStudentToDB(st);
				if (answar)	{
					System.out.println("Student added successfully...");
				} else {
					System.out.println("Something went wrong try again...");
				}
				System.out.println(st);
			}else if(c==2) {
				//delete student..
				System.out.println("Enter Student id to delete:");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f) 
				{
					System.out.println("Deleted...");
				}else
				{
					System.out.println("Something went wrong try again...");
				}
				
			
			}else if (c==3)
			{
				//display student..
				StudentDao.showAllStudent();
			}else if(c==4)
			{
				//exit
				break;
			
			}else
			{
				
			}
		}
		System.out.println("Thank you for using our application.....");
		System.out.println("See you soon.....bye bye");
	}
	

}
