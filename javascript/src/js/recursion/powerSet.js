
function powerSet(arr) {
    var result = []
    var choosen = [];
    helper(arr,choosen,result);
    console.log(result)
}

function helper(arr,choosen,result) {

    if(arr.length <= 0) {
        var temp = []
        for(var i in choosen) {
            temp.push(i)
        }
        result.push(temp);
        return
    }

    var temp = arr.pop();
    choosen.push(temp);
    helper(arr,choosen,result)
    choosen.pop();
    helper(arr,choosen,result);
    arr.push(temp);

}


let arr = ['Jane','Matt','Sara'];
powerSet(arr);