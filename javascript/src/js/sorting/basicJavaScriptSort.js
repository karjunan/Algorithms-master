
function compart(val1,val2) {
    return val1 - val2
}

function basicSortCheck(arr) {

    return arr.sort(compart);

}

let arr = [5,6,3,4,1];
// let arr = ['kri','ram','abc'];

let result = basicSortCheck(arr);
console.log(result);