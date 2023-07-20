package co.yedam.inherit;

public class PhoneExe {
	public static void main(String[] args) {
		CellPhone cellPhone = new CellPhone();

		cellPhone.setModel("Galaxy S10");
		cellPhone.setColor("white");
		cellPhone.powerOn();
		cellPhone.sendMessage();
		cellPhone.powerOff();
		System.out.println(cellPhone.showInfo());
		System.out.println("----------------------");
		// 자식클래스는 부모클래스의 필드,메소드, 생성자.
		DmbCellPhone dmb = new DmbCellPhone();
		dmb.setModel("galaxy dmb 1");
		dmb.setColor("Yellow");
		dmb.powerOn();
		dmb.sendMessage();
		dmb.turnOn();
		dmb.changeChannel(10);
		dmb.turnOff();
		dmb.powerOff();
		System.out.println(dmb.showInfo());

		// 부모클래스의 변수 자식클래스의 변수 대입.
		CellPhone parent = new DmbCellPhone("DMB S22", "white", 10); // promotion
		System.out.println(parent.getModel());
//		parent.turnOn(); //자식클래스의 필드, 메소드 사용이 불가.

		DmbCellPhone child = (DmbCellPhone) parent; // casting
		child.turnOn();
		
		if(parent instanceof DmbCellPhone) {
			child = (DmbCellPhone) parent;  //casting
			child.turnOn();
		}

		// 부모클래스의 변수를 자식변수로 casting 할 경우 체크.
		if (cellPhone instanceof DmbCellPhone) {
			child = (DmbCellPhone) cellPhone;
			child.turnOn();
		}
	}
}
