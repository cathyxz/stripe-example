
export function stringToPhoneNumber(number) {
    number = number.replace(/[^0-9]/g, "")
    if (number.length == 0) {
        return "";
    }
    if (number.length> 0 && number.length <4) {
        return "(" + number;
    } else if (number.length >= 4 && number.length < 7) {
        return "(" + number.substring(0,3) + ") " + number.substring(3, number.length);
    } else if (number.length >= 7) {
        return "(" + number.substring(0,3) + ") " + number.substring(3, 6) + "-" + number.substring(6, 10);
    } else {
        // TODO: handle overflow
        number;
    }
}
