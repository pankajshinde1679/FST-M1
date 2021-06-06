class Car:    
    def __init__(self,manufacturer,model,make,transmission,color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print("The model "+ self.model + " of the "+self.manufacturer+ " car is moving.")
    
    def stop(self):
        print("The model "+ self.model + " of the "+self.manufacturer+ " car has stopped.")

car1 = Car("Toyota","Camry","2009","5","Golden")
car2 = Car("Maruti","Ignis","2014","Auto","Grey")
car3 = Car("Tata","Tigor","2012","5","Orange")

car1.accelerate()
car2.accelerate()
car3.accelerate()

car1.stop()
car2.stop()
car3.stop()

