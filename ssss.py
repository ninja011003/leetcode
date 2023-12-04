import random

# Constants
DAYS = 5
PERIODS = 10
REGULAR_PERIODS = [0, 1, 3, 5, 6, 7, 9]
BREAKS = [2, 5, 8]
POPULATION_SIZE = 100
GENERATIONS = 1000
MUTATION_RATE = 0.1

# Example data - replace with your actual data
subjects = ["Math", "Physics", "Biology"]
faculty_names = ["Dr. Smith", "Prof. Johnson", "Dr. Brown"]
practical_subjects = ["Physics Lab", "Biology Lab"]
subject_credits = {"Math": 3, "Physics": 4, "Biology": 3, "Physics Lab": 2, "Biology Lab": 2}

# Generate random timetable with initial assignments
def generate_timetable():
    timetable=[]
    for _ in range(DAYS):
        day_tt =[]
        for period in range(PERIODS):
            if period in REGULAR_PERIODS:
                day_tt.append({
                "Subject": random.choice(subjects),
                "Faculty": random.choice(faculty_names),
                "Credits": subject_credits[random.choice(subjects)]
            })
            else:
                day_tt.append({
                "Subject": "break",
                "Faculty": "",
                "Credits": ""
            })
        timetable.append(day_tt)

    # timetable = [
    #     [
    #         {
    #             "Subject": random.choice(subjects),
    #             "Faculty": random.choice(faculty_names),
    #             "Credits": subject_credits[random.choice(subjects)]
    #         } if period in REGULAR_PERIODS else
    #         {"Break": True}
    #         for period in range(PERIODS)
    #     ]
    #     for _ in range(DAYS)
    # ]
    return timetable

# Fitness function
def fitness(timetable):
    score = 0
    for day in timetable:
        for i in range(len(day) - 1):
            if "Subject" in day[i] and "Subject" in day[i + 1] and day[i]["Subject"] == day[i + 1]["Subject"]:
                score -= 1
    return score

# Selection: Tournament selection
def tournament_selection(population, tournament_size):
    selected = []
    for _ in range(len(population)):
        candidates = random.sample(population, tournament_size)
        winner = max(candidates, key=lambda x: fitness(x))
        selected.append(winner)
    return selected

# Crossover: One-point crossover
def crossover(parent1, parent2):
    point = random.randint(1, len(parent1) - 1)
    child1 = parent1[:point] + parent2[point:]
    child2 = parent2[:point] + parent1[point:]
    return child1, child2

# Mutation: Randomly change a class in a day
def mutate(individual):
    if random.uniform(0, 1) < MUTATION_RATE:
        day = random.randint(0, DAYS - 1)
        period = random.choice(REGULAR_PERIODS)
        subject = random.choice(subjects)
        faculty = random.choice(faculty_names)
        credits = subject_credits[subject]
        individual[day][period] = {"Subject": subject, "Faculty": faculty, "Credits": credits}
    return individual

# Genetic Algorithm
def genetic_algorithm():
    # Initialize population
    population = [generate_timetable() for _ in range(POPULATION_SIZE)]

    for generation in range(GENERATIONS):
        # Select parents
        parents = tournament_selection(population, 5)

        # Create next generation
        new_population = []
        for i in range(0, POPULATION_SIZE, 2):
            parent1, parent2 = random.sample(parents, 2)
            child1, child2 = crossover(parent1, parent2)
            child1 = mutate(child1)
            child2 = mutate(child2)
            new_population.extend([child1, child2])

        # Replace old population with the new one
        population = new_population

        # Print the best individual in the current generation
        best_individual = max(population, key=lambda x: fitness(x))
        print(f"Generation {generation + 1}, Fitness: {fitness(best_individual)}")

    # Print the final timetable
    best_individual = max(population, key=lambda x: fitness(x))
    print("\nFinal Timetable:")
    print(best_individual)
    for day, classes in enumerate(best_individual, start=1):
        print(f"Day {day}: {classes}")

if __name__ == "__main__":
    genetic_algorithm()
