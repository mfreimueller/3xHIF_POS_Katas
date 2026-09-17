// Does not compile: an implicitly declared class has no name that can be
// written in source code. `BrokenGreeter.printSummary(...)` tries to
// qualify a call with the class's (compiler-internal) name, which is
// illegal here — methods inside the same implicit class must be called
// unqualified.

int greetingCount = 0;

void main() {
    greet("Alice");
    greet("Bob");
    BrokenGreeter.printSummary(greetingCount);
}

void greet(String name) {
    System.out.println("Hello, " + name + "!");
    greetingCount++;
}

void printSummary(int count) {
    System.out.println("Greeted " + count + " people");
}
