function selectionSort(arr) {

    var i = 0;
    while( i < arr.length) {
        var min = arr[i];
        var pos = j;
        var j = i;
        while( j < arr.length ) {
            if(arr[j] < min) {
                pos = j;
                min = arr[j];                    
            }
            j++;
        }
        if( min < arr[i]) {
            var temp = arr[i];
            arr[i] = min;
            arr[pos] = temp;
            console.log(arr);
        }   
        i++;
    }
    return arr;
}

let elements = [6,5,4,3,2,1];
// let elements = [5,3,6,1,8];
// let elements = [1]
console.log(elements)
let result = selectionSort(elements);

console.log(result);