
let value = [45,34,12,9,8,90,3]


function oddEvenReorder(value) {

  let temp = 0;
  for( let i = 0 ; i < value.length; i++) {

    if(temp == 0 && value[i] % 2 !== 0) {
      temp = i
    }

    if(value[i] % 2 == 0) {
        let current = value[i];
        value[i] = value[temp];
        value[temp] = current;
        temp = i;

    }

    console.log(value);
  }

}


oddEvenReorder(value);
