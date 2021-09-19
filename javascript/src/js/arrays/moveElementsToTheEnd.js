
function moveElementToEnd(arr, toMove) {
    var i = 0;
    var j = arr.length - 1;

    while(i <= j) {
        if(arr[i] != toMove) {
            console.log("i th value => " +i);
            i++;
            continue;
        } else if(arr[j] === toMove) {
            j--;
            continue;
        } else if(arr[i] === toMove && arr[j] != toMove && i < j) {
            swap(i,j,arr); 
        }
        i++;
        j--;
    }

    return arr;
}

function swap(i,j,arr) {
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

// let array = [2,1,2,2,2,3,4,2]
// let array = [3, 1, 2, 5, 4]
let array = [1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 5, 5, 5, 5, 5, 5]
let toMove = 5

let result = moveElementToEnd(array,toMove);
console.log(result)


  