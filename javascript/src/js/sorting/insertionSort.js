

function insertionSort(arr) {

    var i = 0;
    while( i < arr.length) {
        var j = i + 1;
        while( j > 0 && j < arr.length) {
            if(arr[j] < arr[j-1]) {
                var temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp; 
            }
            j--;
        }
        i++;
        if(j >= arr.length) {
            break;
        }
        console.log(arr);
    }
return arr;
}

let elements = [6,5,4,3,2,1];
// let elements = [5,3,6,1,8];
// let elements = [1]
let  result = insertionSort(elements);
console.log(result);