function minsubarray(arr, value) {

    var i = 0;
    var j = 0;
    var sum = 0;
    var elem = [];

    while( i < arr.length ) {

        if(sum < value && j < arr.length) {
            sum = sum + arr[j++];
        } 
        else if(sum > value) {
          
        }

    }

}

// let elements = [2,3,1,2,4,3]
let elements = [2,1,6,5,4,3]

let result = minsubarray(elements,9)
var min = 100000
for(var i = 0 ; i < result.length; i++) {
    if(result[i] < min) {
        min = result[i];
    }
}
console.log("Final Result => ", result, "and the minimum is => ", min);
