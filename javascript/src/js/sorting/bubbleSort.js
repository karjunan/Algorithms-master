
function bubbleSort(arr) {

    for(var i = arr.length-1; i >= 0; i--) {
        for(var j = 0 ; j < i; j++) {
            if(arr[j] > arr[j+1]) {
                var temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
  return arr;
}

let elements = [6,5,4,3,2,1];
// let elements = [5,3,6,1,8];
let result = bubbleSort(elements);
console.log(result);