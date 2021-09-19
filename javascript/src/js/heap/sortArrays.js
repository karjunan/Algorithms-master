function mergeArraysWithHeap(arr) {
    var position = []
    for( var i = 0 ; i < arr.length; i++) {
        position[i] = 0;
    }

    var t = 0;
    for(var i=0 ; i < arr.length; i++) {
        for(var j = 0 ; j < arr[i].length; j++) {
            t++;
        }   
    }
    var k = 0;
    var temp = [];
    while(t > 0) {
        var min = Number.MAX_SAFE_INTEGER;
        var index = -1;
        for(var i = 0 ; i < arr.length; i++) {
            var columnPosition = position[i];
            if(position[i] > arr[i].length-1) {
                continue;
            } 
            console.log("current Column value =>", arr[i][columnPosition])
            if(arr[i][columnPosition] < min) {
                min = arr[i][columnPosition];
                index = i;
            }
        }
        temp.push(arr[index][position[index]]);
        arr[index][position[index]] = undefined
        console.log("Current position => " + position , array)
        console.log("Temp => ", temp)

        position[index] = position[index] + 1
        t--;
    }

    console.log("Final sorted List => ", temp)
    return temp;

}

function mergeArrays(arr) {
    var position = []
    for( var i = 0 ; i < arr.length; i++) {
        position[i] = 0;
    }

    var t = 0;
    for(var i=0 ; i < arr.length; i++) {
        for(var j = 0 ; j < arr[i].length; j++) {
            t++;
        }   
    }
    var k = 0;
    var temp = [];
    while(t > 0) {
        var min = Number.MAX_SAFE_INTEGER;
        var index = -1;
        for(var i = 0 ; i < arr.length; i++) {
            var columnPosition = position[i];
            if(position[i] > arr[i].length-1) {
                continue;
            } 
            console.log("current Column value =>", arr[i][columnPosition])
            if(arr[i][columnPosition] < min) {
                min = arr[i][columnPosition];
                index = i;
            }
        }
        temp.push(arr[index][position[index]]);
        arr[index][position[index]] = undefined
        console.log("Current position => " + position , array)
        console.log("Temp => ", temp)

        position[index] = position[index] + 1
        t--;
    }

    console.log("Final sorted List => ", temp)
    return temp;

}

let array = [ 
    [ 1, 5, 9, 21 ],
    [ -1, 0 ],
    [ -124, 81, 121 ],
    [ 3, 6, 12, 20, 150 ] 
]
let result = mergeArrays(array);
console.log(result);