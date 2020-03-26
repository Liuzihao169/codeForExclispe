package day1.demo4;

public class PetHospital {
  public void Hairdiy(Pet pet){
	  pet.color="red";
  }
  public Pet produce(String name){
	  switch(name){
	  case "cat":
		  return new Cat("xiaoxao","hong",15,"yellow");
		  default:
			  return null;
	  }
	  
	  
  }
}
