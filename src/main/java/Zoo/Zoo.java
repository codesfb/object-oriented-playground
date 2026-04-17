import Zoo.Animal;
import Zoo.Lion;
import Zoo.Owl;
import Zoo.Wolf;

void main() {
        Animal[] jaulas = {new Lion(), new Owl(), new Lion(), new Wolf(), new Wolf(),
                new Lion(), new Owl(), new Lion(), new Wolf(), new Wolf()};
        for (Animal animal : jaulas) {
            animal.makeSound();
            if (animal instanceof Lion) {
                ((Lion) animal).run();
            } else if (animal instanceof Wolf) {
                ((Wolf) animal).run();
            }
        }
    }
}

