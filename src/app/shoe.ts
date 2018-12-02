import { User } from './User';

export class Shoe{
    id: number;
    client: User;
    title: string;
    brand: string;
    shoeSize: number;
    price: number;
    uploadedFile: File;
    imageUrl: string;
    color: string;
    public _shoeStatus: number;
    public get shoeStatus(): number {
        return this._shoeStatus;
    }
    public set shoeStatus(value: number) {
        this._shoeStatus = value;
    }
}