package Practice.src.warmup;

import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Main class should be named 'Solution' and should not be public.
class UserJourneyService {
    public static void main(String[] args) {

        JourneService journeyService = new JourneServiceImpl();
        StageService stageService = new StageServiceImpl();
        UserService userService = new UserServiceImpl(journeyService, stageService);

        // Create User
        userService.createUser(new User("Ram"));
        userService.createUser(new User("Shyam"));
        userService.createUser(new User("Sita"));
        userService.createUser(new User("Gita"));

        // Create Journey
        // 1. Create Action and Stage
        List<Stage> stages = new ArrayList<>();
        stages.add(new Stage(new Action("ABCD", false), true, true, false));
        stages.add(new Stage(new Action("BCDE", false), false, false, false));
        stages.add(new Stage(new Action("EFGH", false), false, false, true));

        Journey journey1 = journeyService.createJourney(new Journey(stages, true));
        Journey journey2 = journeyService.createJourney(new Journey(stages, true));
    }
}

interface UserService {
    public void createUser(User user);

    public User getUser(String userId);

    public boolean evaluate(String userId, Payload payload);

    public void onboard(String userId, String journeyId);

    public boolean isOnboarded(String userId, String journeyId);

    public Stage getCurrentStage(String userId, String journeyId);
}

class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    private Map<String, User> usersMap = new HashMap<>();

    private Set<String> userIdAndJourneyIdSet = new HashSet<>();

    private final JourneService journeService;

    private final StageService stageService;

    public UserServiceImpl(
            JourneService journeService, StageService stageService
    ) {
        this.journeService = journeService;
        this.stageService = stageService;
    }

    public void createUser(User user) {
        users.add(user);
        usersMap.put(user.getUserId(), user);
    }

    public boolean evaluate(String userId, Payload payload) {

        return true;
    }



    public void onboard(String userId, String journeyId) {

        String key = userId + "_" + journeyId;
        if (!userIdAndJourneyIdSet.contains(key)) {
            Journey journey = this.journeService.getJourney(journeyId);
            User user = getUser(userId);
            user.getJournies().add(journey);
            userIdAndJourneyIdSet.add(key);
        } else {
            throw new RuntimeException("User with id: " + userId + " alredy onboarded to journey: " + journeyId);
        }
    }

    public boolean isOnboarded(String userId, String journeyId) {

        String key = userId + "_" + journeyId;
        if (userIdAndJourneyIdSet.contains(key)) {
            Journey journey = this.journeService.getJourney(journeyId);
            return journey.isActive();
        }
        return false;
    }

    public Stage getCurrentStage(String userId, String journeyId) {

        User user = getUser(userId);
        List<Journey> journies = user.getJournies();
        if (journies != null && journies.size() > 0) {
            Journey journey = this.journeService.getJourney(journies, journeyId);
            return this.stageService.getCurrentStage(journey.getStages());
        } else {
            throw new RuntimeException("Currently user with id: " + userId + "doesn't have any  journey with id: " + journeyId
            );
        }
    }

    public User getUser(String userId) {

        if (usersMap.containsKey(userId)) {
            return usersMap.get(userId);
        } else {
            throw new RuntimeException("User not found: " + userId);
        }
    }
}

interface StageService {

    public Stage getCurrentStage(List<Stage> stages);
}

class StageServiceImpl implements StageService {

    public Stage getCurrentStage(List<Stage> stages) {

        if (stages.isEmpty()) {
            throw new RuntimeException("Stages are empty:");
        }
        Stage foundStage = stages.stream().filter(stage -> stage.isActive()).findAny().get();
        if (foundStage != null) {
            return foundStage;
        } else {
            throw new RuntimeException("No Actice stage was found:");
        }
    }
}

interface JourneService {
    public Journey createJourney(Journey journey);

    public void updateState(String JourneyId, boolean active);

    public Journey getJourney(String JourneyId);

    public Journey getJourney(List<Journey> journies, String JourneyId);
}

class JourneServiceImpl implements JourneService {

    private List<Journey> journies = new ArrayList<>();

    private Map<String, Journey> journeyMap = new HashMap<>();

    public Journey createJourney(Journey journey) {
        journies.add(journey);
        journeyMap.put(journey.getJourneyId(), journey);
        return journey;
    }

    public void updateState(String journeyId, boolean active) {

        Journey journey = getJourney(journeyId);
        journey.setActiveFlag(active);
    }

    public Journey getJourney(String journeyId) {

        if (journeyMap.containsKey(journeyId)) {
            return journeyMap.get(journeyId);
        } else {
            throw new RuntimeException("Journey not found: " + journeyId);
        }
    }

    public Journey getJourney(List<Journey> journies, String journeyId) {

        Journey foundJourney = journies.stream().filter(journey -> journeyId.equals(journey.getJourneyId())).
                findAny().get();
        if (foundJourney != null) {
            return foundJourney;
        } else {
            throw new RuntimeException("Journey not found: " + journeyId);
        }
    }
}

class User {

    private String userId;

    private String userName;

    private List<Journey> journies = new ArrayList<>();

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public List<Journey> getJournies() {
        return this.journies;
    }

    public void setJournies(List<Journey> journies) {
        this.journies = journies;
    }
}

class Journey {

    private String journeyId;

    private boolean active;

    private List<Stage> stages;

    public Journey(List<Stage> stages, boolean active) {
        this.journeyId = UUID.randomUUID().toString();
        this.stages = stages;
        this.active = active;
    }

    public String getJourneyId() {
        return this.journeyId;
    }

    public void setJourneyId(String journeyId) {
        this.journeyId = journeyId;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActiveFlag(boolean active) {
        this.active = active;
    }

    public List<Stage> getStages() {
        return this.stages;
    }
}

class Stage {

    private String stageNo;

    private Action action;

    private boolean active;

    private boolean isOnboardingStage;

    private boolean isFinalStage;

    private List<Stage> stages;

    public Stage(Action action, boolean active, boolean isOnboardingStage, boolean isFinalStage) {

        this.action = action;
        this.active = active;
        this.isOnboardingStage = isOnboardingStage;
        this.isFinalStage = isFinalStage;
    }

    public String getStageNo() {
        return this.stageNo;
    }

    public boolean isActive() {
        return this.active;
    }

    public Action getAction() {
        return this.action;
    }

    public boolean isOnboardingStage() {
        return this.isOnboardingStage;
    }

    public boolean isFinalStage() {
        return this.isFinalStage;
    }
}

class Action {

    private String actionId;

    private String taskDescription;

    private boolean isActionCompleted;

    public Action(String taskDescription, boolean isActionCompleted) {
        this.taskDescription = taskDescription;
        this.isActionCompleted = isActionCompleted;
    }

    public String getActionId() {
        return this.actionId;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public boolean isActionCompleted() {
        return this.isActionCompleted;
    }
}

class Payload {

    private String eventId;

    private String eventTime;

    private Map<String, Object> eventPayload;
}
