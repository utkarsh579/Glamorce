import { Address } from "./Address";


export type User = {
    name?: string;
    mobileNo?: string;
    gender?: string;
    address:Address;
    customerEmail?:string;
    profilePhoto?: any;
}