function uniqueNumbers(values) {

    var i = 0; 
    var k = 1;
    var counter = 1;
    if(values.length == 0) {
        return 0;
    }
    while(k < values.length) {
        if(values[i] - values[k] == 0 ) {
            k++;
            continue;
        }
        counter++;
        i = k;
    }
 return counter;
}

function uniqueNumbersV1(values) {

    var i = 0;
    var j = 1;

    while(j < values.length) {
        if(values[j] == values[i]) {
            j++;
            continue;
        }
        i++;
        values[i] = values[j];
        console.log(values);
    }
    return i+1;
}

let values = [1,1,1,1,2,2,3]
// let values = [1,2,3,4,4,5,6,6]
// let values = [-2,-1,1,1]

let result = uniqueNumbersV1(values)
console.log(result);
