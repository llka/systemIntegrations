package ru.ilka.systemintegration.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.ilka.systemintegration.entity.*;

import java.util.List;

@Service
public class MatrixLogic {
    private static Logger logger = LogManager.getLogger(MatrixLogic.class);

    private static final int TOP_HEADER_RAW_IDX = 0;
    private static final int LEFT_HEADER_COLUMN_IDX = 0;
    private static final int INTEGRATIONS_BLOCK_FIRST_IDX = 1;
    private static final String EMPTY_CELL = " - ";
    private static final String INTEGRATION_SYMBOL = " 1 ";

    public MatrixCell[][] buildAdjacencyMatrix(List<ProjectSystem> systems) {
        int size = systems.size();
        int matrixWithHeaderSize = size + INTEGRATIONS_BLOCK_FIRST_IDX;
        MatrixCell[][] matrix = new MatrixCell[matrixWithHeaderSize][matrixWithHeaderSize];

        /* init */
        for (int i = TOP_HEADER_RAW_IDX; i < matrixWithHeaderSize; i++) {
            for (int j = LEFT_HEADER_COLUMN_IDX; j < matrixWithHeaderSize; j++) {
                matrix[i][j] = new MatrixCell(i, j, EMPTY_CELL);
            }
        }

        /* fill in headers */
        for (int j = INTEGRATIONS_BLOCK_FIRST_IDX; j < matrixWithHeaderSize; j++) {
            ProjectSystem system = systems.get(j - INTEGRATIONS_BLOCK_FIRST_IDX);
            matrix[TOP_HEADER_RAW_IDX][j] = new SystemMatrixCell(TOP_HEADER_RAW_IDX, j, system.getSystemId(), system);
            matrix[j][LEFT_HEADER_COLUMN_IDX] = new SystemMatrixCell(j, LEFT_HEADER_COLUMN_IDX, system.getSystemId(), system);
        }

        /* fill in integrations block */
        for (int i = INTEGRATIONS_BLOCK_FIRST_IDX; i < matrixWithHeaderSize; i++) {
            ProjectSystem systemRaw = systems.get(i - INTEGRATIONS_BLOCK_FIRST_IDX);
            for (int j = INTEGRATIONS_BLOCK_FIRST_IDX; j < matrixWithHeaderSize; j++) {
                ProjectSystem systemColumn = systems.get(j - INTEGRATIONS_BLOCK_FIRST_IDX);
                for (Integration integration : systemRaw.getIntegrationsFrom()) {
                    if (integration.getToProjectSystemId().equals(systemColumn.getSystemId())) {
                        matrix[i][j] = new IntegrationMatrixCell(i, j, INTEGRATION_SYMBOL, integration);
                    }
                }
            }
        }
        return matrix;
    }

    public void printMatrix(MatrixCell[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(String.format("%20s", matrix[i][j].getDisplayedInfo()));
            }
            System.out.println();
        }
    }
}
