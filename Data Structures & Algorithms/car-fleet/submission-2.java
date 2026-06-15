class Solution {
    record Car(int position, int speed) {}
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length != speed.length || position.length < 1)
            return 0;
        Car[] cars = sortCars(position, speed);
        Deque<Double> fleets = new ArrayDeque<>();

        fleets.push(
            (double) (target - cars[cars.length - 1].position) / cars[cars.length - 1].speed);

            for(int i = cars.length - 2; i>=0; i--){
                double arrTime = (double) (target - cars[i].position) / cars[i].speed;
                System.out.print("arrTime: " + arrTime + ", peek: " + fleets.peek());
                if(arrTime > fleets.peek()){
                    fleets.push(arrTime);
                }
            }
    
    
        return fleets.size();
    }

    private Car[] sortCars(int[] positions, int[] speeds) {
        Car[] cars = new Car[positions.length];
        for (int i = 0; i < positions.length; i++) {
            cars[i] = new Car(positions[i], speeds[i]);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));
        return cars;
    }
}
