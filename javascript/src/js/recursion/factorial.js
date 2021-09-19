function factorial(v) {
  if(v === 1) {
      return 1;
  }
   return v * factorial(v-1);
}

let value = 100;
let result = factorial(value)
console.log("Factorial of " + value + " is  => ", result);

/*
   24
   4 * 6
         3 * 2
                2 * 1
*/