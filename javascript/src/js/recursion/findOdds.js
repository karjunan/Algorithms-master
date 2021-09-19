function findOdds(val) {
    var odds = [];

    function helper(values,val) {
        if(val == values.length) {
            return;
        }

        if(values[val] % 2 != 0) {
            odds.push(values[val]);
        }

        helper(values,val+1);
    }

    helper(val, 0);

    return odds;

}

let values = [9,2,6,8,9,10];
let result = findOdds(values);
console.log(result)