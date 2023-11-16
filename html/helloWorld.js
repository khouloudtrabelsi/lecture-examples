function onClickHello() {
    const greeting = generateHelloWorld();
    alert(greeting);
}

function generateHelloWorld() {
    let wordArray = ["Hello", "World!", "randomWord"]
    let helloString = wordArray[0];
    let worldString = wordArray[1];
    let helloWorldString = helloString + " " + worldString;

    return helloWorldString;
}

const btn = document.querySelector("#myButton");
btn.addEventListener("click", onClickHello);