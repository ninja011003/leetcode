import math

def calculate_coordinates(distance, angle):
    x = distance * math.cos(math.radians(angle))
    y = distance * math.sin(math.radians(angle))
    return x, y

def calculate_distance(coord1, coord2):
    return math.sqrt((coord1[0] - coord2[0])**2 + (coord1[1] - coord2[1])**2)

def find_distance_between_devices(devices, device_id1, device_id2):
    # Find coordinates for both devices
    coord1 = devices[device_id1]['coordinates']
    coord2 = devices[device_id2]['coordinates']

    # Calculate distance between the two devices
    distance = calculate_distance(coord1, coord2)
    return distance

def main():
    # Read input
    N = int(input())
    devices = {}

    # Populate data structure
    for _ in range(N):
        device_info = input().split()
        device_id = int(device_info[0][0])
        num_found_devices = int(device_info[1].split(":")[1])
        print(device_info)
        devices[device_id] = {'num_found_devices': num_found_devices, 'found_devices': []}

        for _ in range(num_found_devices):
            dev_id =input()
            found_device_info = input().split()
            print(found_device_info)
            found_device_id = int(found_device_info[0])
            distance = int(found_device_info[1])
            angle = int(found_device_info[2])
            found_device_coordinates = calculate_coordinates(distance, angle)

            devices[device_id]['found_devices'].append({
                'id': found_device_id,
                'coordinates': found_device_coordinates
            })

    # Find distance between specified devices
    device_id1, device_id2 = map(int, input().split())
    distance = find_distance_between_devices(devices, device_id1, device_id2)

    # Print the rounded-off distance
    print(f"{distance:.2f}")

if __name__ == "__main__":
    main()
