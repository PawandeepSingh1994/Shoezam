import { User } from './User';
import { Shoe } from './shoe';

export class Request{
    shoe_req_id: number;
    client_requester: User;
    client_owner: User;
    shoe_requested: Shoe;
    shoe_to_trade: Shoe;
    status: number;
    info: string;
}