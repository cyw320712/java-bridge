package bridge.domain;

import bridge.dto.MovingResultDto;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;

    private int position;
    private List<String> bridge;
    private List<String> result;

    /**
     * 게임 관리 컨트롤러에서 필요한 객체를 생성해 주입한다.
     */
    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        position = 0;
    }

    /**
     * 게임을 시작하는 메서드
     */
    public void initGame(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);

        result = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingResultDto move(String commend) {
        String correctPosition = bridge.get(position);
        boolean completeness = false;

        if (correctPosition.equals(commend)) {
            result.add("O");

            position += 1;

            if (position == bridge.size()) {
                completeness = true;
            }
        } else {
            result.add("X");

            completeness = true;
        }

        return new MovingResultDto(result, completeness);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public List<String> getBridge() {
        return bridge;
    }
}
