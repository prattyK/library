package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

	private void serailizeObject() {

		Employee emp3 = new Employee();
		emp3.setId(1);
		emp3.setName("PK");
		emp3.setAge(30);
		
		Employee emp7 = new Employee();
		emp7.setId(1);
		emp7.setName("PK");
		emp7.setAge(30);

		try (ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream("D:\\Reno-Switch-Latest\\test1.txt"))) {
		
			Employee empl []  = new Employee[2];
			empl[0] = emp3;
			empl[1] = emp7;
			
			output.writeObject(empl);
//			output.writeObject(emp7);
		} catch (Exception ex) {
			System.out.println("Exception in Serilization " + ex.getMessage());
		}
	}

	private void deSerailizeObject() {

		try (ObjectInputStream input = new ObjectInputStream(
				new FileInputStream("D:\\Reno-Switch-Latest\\test1.txt"))) {
			Employee woi[] = (Employee[]) input.readObject();
			System.out.println(woi.length);
		} catch (Exception ex) {

		}
	}

	public static void main(String[] args) {
		SerializationTest st = new SerializationTest();
//		st.serailizeObject();
		st.deSerailizeObject();
	}
}
