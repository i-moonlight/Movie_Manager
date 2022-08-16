/**
 *    Copyright 2019 Sven Loesekann
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
import { Cast } from './cast';

export enum Gender{Unkown=0, Female=1, Male=2}

export interface Actor {
    id: number;
    name: string;
    gender: Gender;
    birthday: Date;
    deathday: Date;
    biography: string;
    place_of_birth: string;
    popularity: number;
    myCasts: Cast[];
}
